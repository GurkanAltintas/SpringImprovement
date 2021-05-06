import React, {Component} from 'react';
import {makeStyles} from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TablePagination from '@material-ui/core/TablePagination';
import TableRow from '@material-ui/core/TableRow';
import TableHeader from "./TableHeader";
import TableContent from "./TableContent";
import axios from "axios";


export default class PaginationTable extends Component {

    handleChangePage = (event, newPage) => {
        this.setState({page: newPage})
    };

    handleChangeRowsPerPage = (event) => {
        this.setState({
            page: 0,
            rowsPerPage: event.target.value

        })
    };
    columns = [
        {id:"name", label:"Name",minWidth:170},
        {id:"surname", label:"Surname",minWidth:170},
        {id:"email", label:"Email",minWidth:170, align:"right"},
        {id:"tcKimlikNo", label:"TC Kimlik No",minWidth:170, align:"right"},
        {id:"studentNumber", label:"Student Number",minWidth:170, align: "right"},
        {id:"update", label:"Update Student", align: "right"},
        {id:"delete", label:"Delete Student", align: "right"},
        {id:"addBook", label:"Add Book", align: "right"}
    ];

    constructor() {
        super();
        this.state = {
            page: 0,
            rowsPerPage: 10
        }
    }



    render() {
        return (
            <Paper>
                <TableContainer>
                    <Table stickyHeader aria-label="sticky table">

                        <TableHeader columns={this.columns}/>
                        <TableContent rows={this.props.rows} columns={this.columns} page={this.state.page}
                                      rowsPerPage={this.state.rowsPerPage}/>
                    </Table>
                </TableContainer>

                <TablePagination
                    rowsPerPageOptions={[10, 25, 100]}
                    component="div"
                    count={this.props.rows.length}
                    rowsPerPage={this.state.rowsPerPage}
                    page={this.state.page}
                    onChangePage={this.handleChangePage}
                    onChangeRowsPerPage={this.handleChangeRowsPerPage}
                />
            </Paper>
        );
    }
}
