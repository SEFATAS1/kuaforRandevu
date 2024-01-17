import { Link, Outlet } from "react-router-dom";
import logo from "@/assets/makas.svg";

function App() {
  return (
    <>
      <nav className="navbar navbar-expand bg-body-tertiary shadow-sm">
        <div className="container-fluid">
          <Link className="navbar-brand" to="/">
            <img src={logo} width={60}></img>
            Kuaför Randevu Otomasyonu
          </Link>
          <ul className="navbar-nav">
            <li className="nav-item">
              <Link className="nav-link" to="/signup">Sign Up</Link>
            </li>
          </ul>
        </div>
      </nav>

      <div className="container mt-3">
        <Outlet></Outlet>
      </div>
    </>
  );
}

export default App;
