import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

function Register() {
  const [user, setUser] = useState({ username: "", password: "" });
  const navigate = useNavigate();

  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const handleRegister = () => {
    axios.post("http://localhost:8081/register", user)
      .then(() => {
        alert("Registered!");
        navigate("/");
      });
  };

  return (
    <div className="container">
      <h2>Register</h2>

      <input name="username" onChange={handleChange} placeholder="Username" />
      <input name="password" onChange={handleChange} placeholder="Password" />

      <button onClick={handleRegister}>Register</button>
    </div>
  );
}

export default Register;