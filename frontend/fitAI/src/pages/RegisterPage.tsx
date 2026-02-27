import { useState } from "react";

export default function RegisterPage(){
  const [sex, setSex] = useState<string>("");
  return(
  <div className="container-fluid py-5 vh-100">
  <div className="row d-flex justify-content-center align-items-center h-100">
    <div className="col-12 col-md-12 col-lg-12">
      <form>
        <div className="row">
          <div className="col-6 mb-3 mt-3">
            <label className="form-label">First Name:</label>
            <input type="text" className="form-control" placeholder="Enter first name" />
          </div>

          <div className="col-6 mt-3 mb-3">
            <label className="form-label">Last Name:</label>
            <input type="text" className="form-control" placeholder="Enter last name" />
          </div>
        </div>

        <div className="mb-3">
          <label className="form-label">Email:</label>
          <input type="email" className="form-control" placeholder="Enter email" />
        </div>

        <div className="mb-3">
          <label className="form-label">Age:</label>
          <input type="number" className="form-control" placeholder="Enter age" />
        </div>

        <div className="mb-3">
          <label className="form-label">Sex:</label>
          <select
            className="form-select"
            value={sex}
            onChange={(e) => setSex(e.target.value)}
          >
            <option value="">Select one</option>
            <option value="M">Male</option>
            <option value="F">Female</option>
          </select>
        </div>

        <button className="btn btn-primary w-100">Create Account</button>
      </form>
    </div>
  </div>
</div>
  );
}
