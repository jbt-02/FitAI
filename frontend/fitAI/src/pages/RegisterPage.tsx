import { useState } from "react";

export default function RegisterPage(){
  const [sex, setSex] = useState<string>("");
  return(
    <>
      <form> 
        <div className="mb-3 mt-3">
          <label className="form-label">First Name:</label>
          <input type="text" className="form-control" placeholder="Enter first name"/>
        </div> 
        <div className="mb-3">
          <label className="form-label">Last Name:</label>
          <input type="text" className="form-control" placeholder="Enter last name"/>
        </div>
        <div className="mb-3">
          <label className="form-label">Email:</label>
          <input type="email" className="form-control" placeholder="Enter email"/>
        </div>
        <div className="mb-3">
          <label className="form-label">Age:</label>
          <input type="number" className="form-control" placeholder="Enter age"/>
        </div>

        <div className="mb-3">
         <label className="form-label">Sex: </label>
         <div className="mb-3">
          <select
            className="form-select"
            id="exampleSelect"
            value={sex}
            onChange={(e) => {
              setSex(e.target.value);
            }}
          >
            <option value="">Select one</option>
            <option value="M">Male</option>
            <option value="F">Female</option>
          </select>
        </div>
      </form>
    </>
  );
}
