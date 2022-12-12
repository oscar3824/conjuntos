import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate } from 'react-router-dom';
import { Link } from "react-router-dom";
const URI ="http://localhost:8080/Propietario/list"
const  Propietario = () => {

    const navigate = useNavigate();
    const [Propietario, setPropietario]=useState([]);

    useEffect(() => {
        getpropietario()
        },[]);

    const getpropietario = async () => {
        try {
            const res = await axios({
                method: "GET",
                url: URI,
            });
            setPropietario(res.data)
        } catch (error) {
            console.log(error)
        }
    }
   
   
    return (
        <div>
            {" "}
    
            <div className='container'>
                <div className='row'>
                    <div className='col'>
                        <Link to="/createPropietario" className='btn btn-outline-primary mt-2 mb-2'><i className="fas fa-plus"></i></Link>Administración de Usuarios
                        <table className='table'>
                            <thead className='table-primary'>
                                <tr>
                                    <th>Nombre</th>
                                    <th>Clave</th>
                                    {/* <th>UserName</th>
                                    <th>Roles</th>
                                    <th>Acciones</th> */}
                                </tr>
                            </thead>
                            <tbody>
                                
                                {Propietario.map((Propietario) => (
                                    <tr>
                                        <td> {Propietario.nombre} </td>
                                        <td> {Propietario.clave} </td>
                                        {/* <td> {Propietario.roles.map((role) => (
                                            role.nombre.replace("ROLE_", "") + " "
                                        ))} </td> */}
                                        {/* <td>
                                            <Link to={`/editPropietario/${Propietario.idPropietario}`} className='btn btn-outline-info'><i className="fas fa-edit"></i></Link>&nbsp;
                                            {Propietario.userName !== sessionStorage.getItem("user") ? (
                                                <button onClick={() => deletePropietario(Propietario.idPropietario)} className='btn btn-outline-danger'><i className="fas fa-trash-alt"></i></button>) : ""}
                                        </td> */}
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    );
};
 
export default Propietario;


    