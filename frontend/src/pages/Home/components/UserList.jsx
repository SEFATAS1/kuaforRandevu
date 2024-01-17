import { useEffect, useState } from "react";
import { loadUsers } from "./api";

export function UserList() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    async function getUsers() {
      const response = await loadUsers();
      setUsers(response.data);
    }

    getUsers();
  }, []);

  return (
    <>
      <div className="table-responsive">
        <table className="table">
          <thead className="thead-dark">
            <tr>
              <th scope="col">ID</th>
              <th scope="col">First Name</th>
              <th scope="col">Last Name</th>
              <th scope="col">Phone</th>
              <th scope="col">E-mail</th>

            </tr>
          </thead>
          <tbody>
            {users.map((users) => (
              <tr key={users.id}>
                <td>{users.id}</td>
                <td>{users.firstName}</td>
                <td>{users.lastName}</td>
                <td>{users.phone}</td>
                <td>{users.email}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
}
