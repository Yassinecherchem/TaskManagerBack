import React from 'react';
import ReactDOM from 'react-dom';
import DashBoard from './app/dashboard';

const App = ()=>{
    return (
        <DashBoard></DashBoard>
    );
};  

const root = createRoot(document.getElementById('root'));
root.render(<App />);
