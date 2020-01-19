import React from 'react';

// common pages
const LostPassPage = React.lazy(() => import('pages/CommonPages/LostPassPage'));
const PeopleRegisterPage = React.lazy(() => import('pages/CommonPages/PeopleRegisterPage/PeopleRegisterPage.js'));
const DemoGenericHomePage = React.lazy(() => import('pages/GenericPages/GenericHomePage/GenericHomePage.js'));


//routes  
const demoRoutes = [
	{ path: '/home', exact: true, name: 'Demo', component: DemoGenericHomePage },
	{ path: '/home/lostPass', exact: true, name: 'Lost pass', component: LostPassPage },
	{ path: '/register/:source', exact: true, name: 'Register', component: PeopleRegisterPage },
];

export default demoRoutes;




