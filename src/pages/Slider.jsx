import React from 'react';
import Carousel from '../component/Carousel';

const Slider = () => {

    const slides = [
        {
            title: "Welcome My Blog1",
            content: ()=>(
                <img src="images/b-01.jpg" alt="b01" />
            )
        },
        {
            title: "Welcome My Blog2",
            content: ()=>(
                <img src="images/b-02.jpg" alt="b02" />
            )
        },
        {
            title: "Welcome My Blog3",
            content: ()=>(
                <img src="images/b-03.jpg" alt="b03" />
            )
        },
        {
            title: "Welcome My Blog4",
            content: ()=>(
                <img src="images/b-04.jpg" alt="b04" />
            )
        },
        {
            title: "Welcome My Blog5",
            content: ()=>(
                <img src="images/b-05.jpg" alt="b05" />
            )
        }
    ];

    return (
        <div className='container'>
            <Carousel 
                slides = {slides}
                speed = {3000}
            />
        </div>
    );
};

export default Slider;