import React, {useState, useEffect} from 'react';
import axios from 'axios';
import styled from 'styled-components';
import Aside from './Aside';
import Post from './Post';
import { Container, Row } from 'react-bootstrap';
import Slider from './Slider';

const Containers = styled.div`
    max-width: 100%;
    width: 1320px;
    display: flex;
    margin:0 auto;
`;
const Posts = styled.div`
    flex: 9;
    display: flex;
    align-items: flex-start;
    justify-content: space-between;
`;

const Home = () => {

    const [mylist, setMylist] = useState([]);
    useEffect(()=>{
        axios.get('/myblog01/blist')
        .then(res => {
            setMylist(res.data);
            console.log(res.data);
        });
    }, []);

    return (
        <>
            <Slider />
            <Containers>
                <Posts>
                    <Container>
                        <Row className='my-5'>
                            {
                                mylist.map((list, index)=>(
                                    <Post 
                                        key={list.num}
                                        id={list.num} 
                                        writer={list.writer}
                                        img={list.fileName}
                                        categorya={list.categorya}
                                        categoryb={list.categoryb}
                                        title={list.title}
                                        content={list.content}
                                        wdate={list.wdate}
                                    />
                                ))
                            }
                        </Row>
                    </Container>
                </Posts>
                <Aside />
            </Containers>
        </>
    );
};

export default Home;