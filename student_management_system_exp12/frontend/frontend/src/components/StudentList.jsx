import { useEffect, useState } from "react";
import axios from "axios";

function StudentList({ refresh }) {
  const [students, setStudents] = useState([]);

  const fetchData = () => {
    axios.get("http://localhost:8081/students")
      .then(res => setStudents(res.data));
  };

  useEffect(() => {
    fetchData();
  }, [refresh]);

  const deleteStudent = (id) => {
    axios.delete(`http://localhost:8080/students/${id}`)
      .then(() => {
        alert("Deleted!");
        fetchData();
      });
  };

  return (
    <div>
      <h3>Student List</h3>

      <table border="1">
        <thead>
          <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Course</th>
            <th>Action</th>
          </tr>
        </thead>

        <tbody>
          {students.map(s => (
            <tr key={s.id}>
              <td>{s.name}</td>
              <td>{s.email}</td>
              <td>{s.course}</td>
              <td>
                <button onClick={() => deleteStudent(s.id)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default StudentList;