import React from 'react';
import { List, Avatar, Row, Col } from 'antd';

class MessageList extends React.Component {

  constructor(props) {
    super(props);
  }
  render() {
    let { 
      messages, 
      isLoading,
      count,
      lastMessage
    } = this.props;
    return (
      <div>
      { isLoading ?
        <p>Loading...</p>
        :
        <div>
          <Row type="flex" justify="space-around" align="middle">
            <Col span={6}>
              <List
                header="Last Message"
                bordered
                itemLayout="horizontal"
                dataSource={lastMessage}
                renderItem={item => (
                  <List.Item>
                    <List.Item.Meta
                      avatar={<Avatar src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png" />}
                      title={<a>{item.date}</a>}
                      description={item.message}
                    />
                  </List.Item>
                )}
              />
              <List
                header={`Message List: (${count})`}
                bordered
                itemLayout="horizontal"
                dataSource={messages}
                renderItem={item => (
                  <List.Item>
                    <List.Item.Meta
                      avatar={<Avatar src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png" />}
                      title={<a>{item.date}</a>}
                      description={item.message}
                    />
                  </List.Item>
                )}
              />
            </Col>
          </Row>
        </div>
      }
      </div>
    );
  }
}

export default MessageList;