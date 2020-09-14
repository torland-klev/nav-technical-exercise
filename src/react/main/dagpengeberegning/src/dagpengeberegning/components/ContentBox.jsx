import React, {Component} from 'react';
import './components.css';

class ContentBox extends Component{
    render(){
        return(
            <div className="contentbox" style={this.props.style}>
                <div className="container">
                    {this.props.children}
                </div>
            </div>
        )
    }
}

export default ContentBox;