import './App.css';
import Menu from './componets/menu/Menu';
import Propietario from './componets/menu/Propietario';
import Pagos from './componets/menu/Pagos';
import Login from './componets/menu/Login';
import Salir from './componets/menu/Salir';
import{BrowserRouter,Route,Routes} from "react-router-dom"

const App= () => {
  return (
        <div className="container">
      <BrowserRouter>
      <Routes>
        <Route path="/" element={<Menu/>}/>
        <Route path="/loguear" element={<Login/>}/>
        <Route path="/propietario" element={<Propietario/>}/>
        <Route path="/pagos" element={<Pagos/>}/>
        <Route path="/salir" element={<Salir/>}/>
      </Routes>
      </BrowserRouter>
            <div className="headerapp">
        
      </div>
      <div>
      </div>
    </div>
  );
}

export default App;
