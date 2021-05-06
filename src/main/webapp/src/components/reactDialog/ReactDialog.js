import React, {Component} from 'react';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';

export default class FormDialog extends Component {

    state={
        inputData:{}
    }

    render() {
        return (
            <div>
                <Dialog open={this.props.open} onClose={this.props.handleClose} aria-labelledby="form-dialog-title">
                    <DialogTitle id="form-dialog-title">Student Info</DialogTitle>
                    <DialogContent>
                        {this.props.textFields.map(fields => this.getTextField(fields.id, fields.label, fields.type))}
                    </DialogContent>
                    <DialogActions>
                        <Button onClick={this.props.handleClose} color="primary">
                            Cancel
                        </Button>
                        <Button onClick={()=>this.props.onSubmit(this.state.inputData)} color="primary">
                            Submit
                        </Button>
                    </DialogActions>
                </Dialog>
            </div>
        );
    }

    handleInputChange=(event)=>{
        event.persist();
        this.setState(prevState =>{
            let inputData={...prevState.inputData};
            inputData[event.target.id]=event.target.value;
            return {...prevState,inputData:inputData}

        })

    }
    getTextField(id, label, type) {
        return <TextField
            autoFocus
            margin="dense"
            id={id}
            label={label}
            type={type}
            fullWidth
            onChange={this.handleInputChange}
        />;
    }
}