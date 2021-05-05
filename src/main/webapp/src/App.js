import React, {Component} from "react";
import PaginationTable from "./components/table/PaginationTable";
import Button from "@material-ui/core/Button";
import PlusIcon from "@material-ui/icons/Add";
import ReactDialog from "./components/reactDialog/ReactDialog"

class App extends Component {
    constructor() {
        super();
        this.state = {
            open: false,

        }
    }
    handleDialogClose = () => {
        this.setState({open: false})
    }
    handleDialogOpen = () => {
        this.setState({open: true})
    }

    render() {
        return (
            <div className="App">

                <Button variant="contained"
                        color="primary"
                        startIcon={<PlusIcon></PlusIcon>}
                        onClick={this.handleDialogOpen}

                >ADD STUDENT</Button>
                <PaginationTable/>
                <ReactDialog open={this.state.open}
                             handleClose={this.handleDialogClose}>

                </ReactDialog>

            </div>
        );
    }

}

export default App;
