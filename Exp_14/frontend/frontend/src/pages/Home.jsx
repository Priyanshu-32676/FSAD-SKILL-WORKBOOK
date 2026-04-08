import { useEffect } from "react";
import { useNavigate } from "react-router-dom";

function Home() {
  const navigate = useNavigate();

  // 🔒 Protection (VERY IMPORTANT)
  useEffect(() => {
    const user = localStorage.getItem("user");
    if (!user) {
      navigate("/");
    }
  }, []);

  // 🔓 Logout
  const logout = () => {
    localStorage.removeItem("user");
    navigate("/");
  };

  return (
    <div className="container">
      <h2>Welcome Home</h2>

      <button onClick={() => navigate("/profile")}>
        Go to Profile
      </button>

      <br /><br />

      <button onClick={logout}>
        Logout
      </button>
    </div>
  );
}

export default Home;