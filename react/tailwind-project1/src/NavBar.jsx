import "./NavBar.css";

function NavBar() {
  return (
    <>
      <script src="https://cdn.jsdelivr.net/npm/alpinejs@2.8.0/dist/alpine.min.js"></script>
      <div className="flex pl-36 md:space-x-8 space-x-reverse  md:w-32 lg:w-48">
        <div className="flex m-4 md:space-x-8 space-x-reverse">
          <img
            src="https://static-assets-web.flixcart.com/batman-returns/batman-returns/p/images/fkheaderlogo_exploreplus-44005d.svg"
            alt="flipkart logo"
          />
          <div className="flex bg-blue-50 rounded">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              viewBox="0 0 24 24"
              fill="currentColor"
              className="size-6 "
            >
              <path
                fillRule="evenodd"
                d="M10.5 3.75a6.75 6.75 0 1 0 0 13.5 6.75 6.75 0 0 0 0-13.5ZM2.25 10.5a8.25 8.25 0 1 1 14.59 5.28l4.69 4.69a.75.75 0 1 1-1.06 1.06l-4.69-4.69A8.25 8.25 0 0 1 2.25 10.5Z"
                clipRule="evenodd"
              />
            </svg>

            <input
              type="text"
              className="rounded bg-blue-50  px-3 sp search"
              placeholder="Search for Products, Brands and more"
            />
          </div>
          
          <div
            id="menu"
           
          ><div  className="origin-top-right hover:gray flex hover:bg-blue-500 hover:text-white">
            
            <a href="" className="w-fit">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 24 24"
                fill="currentColor"
                className="size-6"
              >
                <path
                  fillRule="evenodd"
                  d="M18.685 19.097A9.723 9.723 0 0 0 21.75 12c0-5.385-4.365-9.75-9.75-9.75S2.25 6.615 2.25 12a9.723 9.723 0 0 0 3.065 7.097A9.716 9.716 0 0 0 12 21.75a9.716 9.716 0 0 0 6.685-2.653Zm-12.54-1.285A7.486 7.486 0 0 1 12 15a7.486 7.486 0 0 1 5.855 2.812A8.224 8.224 0 0 1 12 20.25a8.224 8.224 0 0 1-5.855-2.438ZM15.75 9a3.75 3.75 0 1 1-7.5 0 3.75 3.75 0 0 1 7.5 0Z"
                  clipRule="evenodd"
                />
              </svg>
              Login
            </a>
          </div>
            <div
              id="menu-item"
              className=" menu-items grid-flow-col col-auto py-4 fl"
            >
              <a href="">New Cutomer</a>
              <br />
              <a href="">My Profile</a>
              <br />
              <a href="">Flipkar plus zone</a>
              <br />
              <a href="">Orders</a>
              <br />
              <a href="">Whishlist</a>
              <br />
              <a href="">Rewards</a>
              <br />
              <a href="">Gift Card</a>
              <br />
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
// let menu = document.getElementById;

export default NavBar;
