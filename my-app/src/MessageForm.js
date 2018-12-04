import React from 'react';
import axios from 'axios';
import { 
  Input, 
  Button,
  Col,
  Row
} from 'antd';

class MessageForm extends React.Component {

  constructor(props) {
    super(props);

    this.state = {
      messageInput: ''
    };
  }
  onChangeMessage = e => {
    let data = e.target.value;
    this.setState({
      messageInput: data
    });
  }
  onSubmit = () => {
    let { messageInput } = this.state;
    let { onSubmit } = this.props;

    onSubmit(messageInput)
    this.setState({
      messageInput: ''
    });
  }
  render() {
    let { messageInput } = this.state;
    const { TextArea } = Input;
    return (
      <div>
      <Row type="flex" justify="space-around" align="middle">
        <Col span={6}>
          <TextArea
            rows={4}
            value={messageInput}
            onChange={this.onChangeMessage}
          />
        </Col>
      </Row>
      <Row type="flex" justify="space-around" align="middle">
        <Button
          type="primary"
          onClick={this.onSubmit}
        >
          Send Message
        </Button>
      </Row>
      </div>
    );
  }
}

export default MessageForm;