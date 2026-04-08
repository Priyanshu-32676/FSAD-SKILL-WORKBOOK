import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

function Login() {
  const [user, setUser] = useState({ username: "", password: "" });
  const navigate = useNavigate();

  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const handleLogin = () => {
    axios.post("http://localhost:8081/login", user)
      .then(res => {
        if (res.data) {
          localStorage.setItem("user", res.data.username);
          navigate("/home");
        } else {
          alert("Invalid credentials");
        }
      });
  };

  return (
    <div className="container">
      <h2>Login</h2>

      <input name="username" onChange={handleChange} placeholder="Username" />
      <input name="password" onChange={handleChange} placeholder="Password" />

      <button onClick={handleLogin}>Login</button>
    </div>
  );
}

export default Login;