import { useState } from "react";
import AddStudent from "./components/AddStudent";
import StudentList from "./components/StudentList";

function App() {
  const [refresh, setRefresh] = useState(false);

  const reload = () => {
    setRefresh(!refresh);
  };

  return (
    <div>
      <h2>Student Management System</h2>

      <AddStudent refresh={reload} />
      <StudentList refresh={refresh} />
    </div>
  );
}

export default App;