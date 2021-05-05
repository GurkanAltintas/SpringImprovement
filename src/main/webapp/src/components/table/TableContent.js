import TableRow from "@material-ui/core/TableRow";
import TableCell from "@material-ui/core/TableCell";
import TableBody from "@material-ui/core/TableBody";
import React from "react";
import {IconButton} from "@material-ui/core";
import CreateIcon from "@material-ui/icons/Create";
import DeleteIcon from "@material-ui/icons/Delete"
import AddIcon from "@material-ui/icons/Add"

export default function TableContent(props) {

    let iconMap={
        "update":<CreateIcon/>,
        "delete":<DeleteIcon/>,
        "addBook":<AddIcon/>
    }
    function calculatePageBeginning() {
        return props.page * props.rowsPerPage;
    }

    function calculatePageEnd() {
        return props.page * props.rowsPerPage + props.rowsPerPage;
    }

    function createIcon(key){
        return(
            <IconButton>
                {iconMap[key]}
            </IconButton>
        );
    }

    function createTableRow(row) {
        return (
            <TableRow hover role="checkbox"  key={row.studentNumber}>
                {props.columns.map((column) => {
                    let value = row[column.id];
                    if(column.id==="update" || column.id==="delete" || column.id==="addBook"){
                        value=createIcon(column.id);

                    }
                    return (
                        <TableCell key={column.id} align={column.align}>
                            {value}
                        </TableCell>
                    );
                })}
            </TableRow>

        )
    }

    return (
        <TableBody>
            {props.rows.slice(calculatePageBeginning(), calculatePageEnd()).map((row) => {

                return (createTableRow(row)
                );
            })}
        </TableBody>
    );


}