export default function LoginPage(){
  return(
  <div className="container py-5 vh-100">
    <div className="row d-flex justify-content-center align-items-center h-100">
        <div className="col-12 col-md-8 col-lg-6">
          <form>
            <div className="mt-3 mb-3">
              <label className="form-label">Email:</label>
              <input type="email" className="form-control" placeholder="Enter email"/>
            </div>
            <div className="mb-3">
              <label className="form-label">Password:</label>
              <input type="password" className="form-control" placeholder="Enter password"/>
            </div>
            <button className="btn btn-primary w-100">Sign in</button>
          </form>
        </div>
    </div>
  </div>
  );
}
