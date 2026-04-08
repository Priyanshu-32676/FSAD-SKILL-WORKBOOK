import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import Login from "./pages/Login";
import Register from "./pages/Register";
import Home from "./pages/Home";
import Profile from "./pages/Profile";

function App() {
  return (
    <BrowserRouter>

      {/* NAVBAR */}
      <nav style={{padding: "10px", background: "#007bff"}}>
        <Link to="/home" style={{color: "white", margin: "10px"}}>Home</Link>
        <Link to="/profile" style={{color: "white", margin: "10px"}}>Profile</Link>
        <Link to="/" style={{color: "white", margin: "10px"}}>Login</Link>
      </nav>

      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/home" element={<Home />} />
        <Route path="/profile" element={<Profile />} />
      </Routes>

    </BrowserRouter>
  );
}

export default App;