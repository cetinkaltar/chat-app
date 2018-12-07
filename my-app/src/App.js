import React, { Component } from 'react';
import './App.css';
import MessageList from './MessageList';
import MessageForm from './MessageForm';
import axios from 'axios';

class App extends Component {
  constructor(props) {
    super(props);

    this.state = {
      messages: [],
      lastMessage:[],
      isLoading: false
    };
  }
  componentDidMount() {
    this.getMessages();
    this.setState({isLoading: true});
  }
  getMessages = async () => {
    let messages = await axios.get('http://localhost:8080/api/all');
    let lastMessage = await axios.get('http://localhost:8080/api/last');
    let count = await axios.get('http://localhost:8080/api/count');
    console.log(lastMessage);
    this.setState({
      messages: messages.data,
      lastMessage: lastMessage.data,
      count: count.data,
      isLoading: false
    });
  }
  sendMessage = async (messageInput) => {
    // TODO Unnecessary variable
    let response = await axios.post('http://localhost:8080/api/set', {}, {
      // TODO Why message as params and not request body?
      // Long messages will throw: IllegalArgumentException: Request header is too large
      params: {
        msg: messageInput
      }
    });
    await this.getMessages();
  }
  render() {
    let { 
      messages, 
      isLoading,
      count,
      lastMessage
    } = this.state;
    return (
      <div className="App">
          <MessageList 
            messages={messages}
            isLoading={isLoading}
            count={count}
            lastMessage={lastMessage}
          />
          <MessageForm
            onSubmit={this.sendMessage} 
          />
      </div>
    );
  }
}

export default App;
