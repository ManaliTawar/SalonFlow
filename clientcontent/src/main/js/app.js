'use strict';

const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {contents: []};
    }

    componentDidMount() {
        client({method: 'GET', path: '/client/content'}).done(response => {
            this.setState({contents: response.entity._embedded.contents});
        });
    }

    render() {
        return (
            <ContentList contents={this.state.contents}/>
        )
    }
}

class ContentList extends React.Component{
    render() {
        const contents = this.props.contents.map(content =>
            <Content key={content._links.self.href} content={content}/>
        );
        return (
            <table>
                <tbody>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Description</th>
                </tr>
                {contents}
                </tbody>
            </table>
        )
    }
}

class Content extends React.Component{
    render() {
        return (
            <tr>
                <td>{this.props.content.name}</td>
                <td>{this.props.content.occupation}</td>
                <td>{this.props.content.contact}</td>
            </tr>
        )
    }
}
ReactDOM.render(
    <App />,
    document.getElementById('react')
)