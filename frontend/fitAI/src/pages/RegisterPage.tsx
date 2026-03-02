import { useState } from "react";
import { register } from "../api/auth";

interface RegisterForm{
  firstName: string;
  lastName: string;
  email: string;
  age: number;
  sex: string;
}

export default function RegisterPage(){
  const [ registerForm, setRegisterForm ] = useState<RegisterForm>({
    firstName: "",
    lastName: "",
    email: "",
    age: 0,
    sex: ""
  });

  const [onSubmit, setOnSubmit] = useState<boolean>(false);

  return(
  <div className="container-fluid py-5 vh-100 w-75">
  <div className="row d-flex justify-content-center align-items-center h-100">
    <div className="col-12 col-md-8 col-lg-6">
      <form>
        <div className="row">
          <div className="col-6 mb-3 mt-3">
            <label className="form-label">First Name:</label>
            <input type="text" className="form-control" onChange={(e) => setRegisterForm({...registerForm, firstName: e.target.value})} placeholder="Enter first name" />
          </div>

          <div className="col-6 mt-3 mb-3">
            <label className="form-label">Last Name:</label>
            <input type="text" className="form-control" onChange={(e) => setRegisterForm({...registerForm, lastName: e.target.value})} placeholder="Enter last name" />
          </div>
        </div>

        <div className="mb-3">
          <label className="form-label">Email:</label>
          <input type="email" className="form-control" onChange={(e) => setRegisterForm({...registerForm, email: e.target.value})} placeholder="Enter email" />
        </div>

        <div className="mb-3">
          <label className="form-label">Age:</label>
          <input type="number" className="form-control" onChange={(e) => setRegisterForm({...registerForm, age: e.target.value})} placeholder="Enter age" />
        </div>

        <div className="mb-3">
          <label className="form-label">Sex:</label>
          <select
            className="form-select"
            value={registerForm.sex}
            onChange={(e) => setRegisterForm({...registerForm, sex: e.target.value})}
          >
            <option value="">Select one</option>
            <option value="M">Male</option>
            <option value="F">Female</option>
          </select>
        </div>

        <button type="button" className="btn btn-primary w-100" disabled={onSubmit} onClick={() => {setOnSubmit(true);handleRegister(registerForm);}}>{onSubmit ? "Loading..." : "Create Account"}</button>
      </form>
    </div>
  </div>
</div>
  );
}


const validateEmail = (email : string) => {
  if(email.length === 0){return false;}
  const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
  return emailPattern.test(email);
}

const handleRegister = async (formData : RegisterForm) => {
  if(!validateEmail(formData.email)){alert("Bad email");return;}
  try{
    const response = await register(formData);
  }catch(error){
    console.error(error);
  } 
}
