var FlashMessage = React.createClass({

    getDefaultProps: function() {
        return {
            message: '',
            distance: '',
            wrapperClass: 'notification',
            onComplete: function() {}
        };
    },

    getInitialState: function() {
        return {
            message: this.props.message,
            distance: this.props.distance
        };
    },

    componentWillReceiveProps: function(props) {
        this.setState({
            message: props.message,
            distance: props.distance
        });
    },

    render: function() {
        var wrapperClass = this.state.message ? this.props.wrapperClass : (this.props.wrapperClass + ' hide');
        return (
            <div className={wrapperClass}>
              <i></i> <span className="notifyMessage">{this.state.message}</span> <span className="pull-right notifyInfo">{parseFloat(this.state.distance).toFixed(2) + 'm away'}</span>
            </div>
        );
    }
});
