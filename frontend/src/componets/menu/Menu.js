import { Link } from "react-router-dom";

const Menu = () => {
    return ( 
       
       
                <nav className="navbar navbar-expand-lg navbar-light bg-light">
  <div className="container-fluid">
  <Link className="navbar-brand" to="/">Inicio</Link>
    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button>
    <div className="collapse navbar-collapse" id="navbarNav">
      <ul className="navbar-nav">
        <li className="nav-item">
          <Link className="navbar-brand" to="/pagos">Pagos</Link>
        </li>
        <li className="nav-item">
          <Link className="navbar-brand" to="loguear">Login</Link>
        </li>
        <li className="nav-item">
          <Link className="navbar-brand" to="/salir">Salir</Link>
        </li>
        <li className="nav-item">
          <Link className="navbar-brand" to="/propietario">Propietario</Link>
        </li>
        <li className="nav-item">
        </li>
      </ul>
    </div>
  </div>
</nav>
            
    );
}
 
export default Menu ;