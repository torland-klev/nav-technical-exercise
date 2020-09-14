import React, {Component} from 'react';

import {isMobile} from 'react-device-detect';
import './components.css';

class ContentBox extends Component{
    render(){
        return(
            <div className={(isMobile) ? "contentboxMobile" : "contentbox"} style={this.props.style}>
                <div className="container">
                    {this.props.children}
                </div>
            </div>
        )
    }
}

export default ContentBox;