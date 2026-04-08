import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

function Profile() {
  const [data, setData] = useState({});
  const navigate = useNavigate();

  useEffect(() => {
    const user = localStorage.getItem("user");

    // 🔒 Protect route
    if (!user) {
      navigate("/");
      return;
    }

    // 📡 Fetch user data from backend
    axios.get(`http://localhost:8081/user/${user}`)
      .then(res => setData(res.data))
      .catch(err => {
        console.error(err);
        alert("Failed to load profile");
      });
  }, []);

  return (
    <div className="container">
      <h2>👤 User Profile</h2>

      <div style={{ textAlign: "left", marginTop: "20px" }}>
        <p><b>User ID:</b> {data.id}</p>
        <p><b>Username:</b> {data.username}</p>
        <p><b>Password:</b> {data.password}</p>
      </div>

      <br />

      <button onClick={() => navigate("/home")}>
        ⬅ Back to Home
      </button>
    </div>
  );
}

export default Profile;