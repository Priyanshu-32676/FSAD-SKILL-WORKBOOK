import { useState } from "react";
import axios from "axios";

function AddStudent({ refresh }) {
  const [student, setStudent] = useState({
    name: "",
    email: "",
    course: ""
  });

  const handleChange = (e) => {
    setStudent({ ...student, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    axios.post("http://localhost:8081/students", student)
      .then(() => {
        alert("Student Added!");
        setStudent({ name: "", email: "", course: "" });
        refresh();
      });
  };

  return (
    <div>
      <h3>Add Student</h3>

      <form onSubmit={handleSubmit}>
        <input name="name" placeholder="Name" value={student.name} onChange={handleChange} />
        <input name="email" placeholder="Email" value={student.email} onChange={handleChange} />
        <input name="course" placeholder="Course" value={student.course} onChange={handleChange} />
        <button type="submit">Add</button>
      </form>
    </div>
  );
}

export default AddStudent;