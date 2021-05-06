import React, {Component} from "react";
import PaginationTable from "./components/table/PaginationTable";
import Button from "@material-ui/core/Button";
import PlusIcon from "@material-ui/icons/Add";
import ReactDialog from "./components/reactDialog/ReactDialog"
import axios from "axios";

class App extends Component {

    studentDialogFields = [
        {id: "name", label: "Name", type: "text"},
        {id: "surname", label: "Surname", type: "text"},
        {id: "email", label: "Email", type: "text"},
        {id: "tcKimlikNo", label: "TC Kimlik No", type: "text"},
        {id: "studentNumber", label: "Student Number", type: "text"}
    ];

    constructor() {
        super();
        this.state = {
            open: false,
            rows: []

        }
    }

    handleDialogClose = () => {
        this.setState({open: false})
    }
    handleDialogOpen = () => {
        this.setState({open: true})
    }

    componentDidMount() {
        axios.get("/students").then(response =>
            this.setState({rows: response.data}))
    }

    handleStudentAddSubmit = (info) => {
        axios.post("/students", info).then(response => {
            this.handleDialogClose();
            this.setState(prevState=>({
                rows:[...prevState.rows,response.data]}))
        })
    }

    render() {
        return (
            <div className="App">

                <Button variant="contained"
                        color="primary"
                        startIcon={<PlusIcon></PlusIcon>}
                        onClick={this.handleDialogOpen}

                >ADD STUDENT</Button>
                <PaginationTable rows={this.state.rows}/>
                <ReactDialog
                    onSubmit={this.handleStudentAddSubmit}
                    open={this.state.open}
                    handleClose={this.handleDialogClose}
                    textFields={this.studentDialogFields}
                >

                </ReactDialog>

            </div>
        );
    }

}

export default App;
