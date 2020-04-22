import Home from './views/Home/Home'
import BorrowRecords from "~/views/reader/BorrowRecords";
import OrdainRecords from "~/views/reader/OrdainRecords";
import Login from "~/views/login/Login";
import Logined from "~/views/login/Logined";
import Help from "~/views/help/Help";

export const routes = [
    {
        path:'/',
        component:Home
    },
    {
        path:'/Home',
        component:Home
    },
    {
        path:'/BorrowRecords',
        component:BorrowRecords
    },
    {
        path:'/OrdainRecords',
        component:OrdainRecords
    },
    {
        path:'/Login',
        component:Login
    },
    {
        path:'/Logined',
        component:Logined
    },
    {
        path:'/Help',
        component:Help
    },
];