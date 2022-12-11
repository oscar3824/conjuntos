const Login = () => {
    return ( 
        <section className="vh-100">
        <div className="container-fluid h-custom">
          <div className="row d-flex justify-content-center align-items-center h-100">
            <div className="col-md-9 col-lg-6 col-xl-5">
              <img src="https://th.bing.com/th/id/OIP.ePZmYg50yne9VyZUHF6beAHaFE?pid=ImgDet&rs=1"
                className="img-fluid" alt="Sample image"/>
            </div>
          </div>
        </div>
        <form>
        <div className="form-outline mb-4">
            <input type="email" id="form3Example3" className="form-control form-control-lg"
              placeholder="Enter a valid email address" />
            <label className="form-label" for="form3Example3">Email address</label>
          </div>
          <div className="form-outline mb-3">
            <input type="password" id="form3Example4" className="form-control form-control-lg"
              placeholder="Enter password" />
            <label className="form-label" for="form3Example4">Password</label>
          </div>
          <div className="d-flex justify-content-between align-items-center">
            
            
            </div>
            <div class="text-center text-lg-start mt-4 pt-2">
            <a className="btn btn-primary">Login</a>
           </div>
          
        </form>
      </section>


      
    ); 
};
 
export default Login;