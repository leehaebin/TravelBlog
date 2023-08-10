import React, {useState, useEffect} from 'react';
import { Button, Card, Col } from 'react-bootstrap';

const Post = ({id, writer, img, categorya, categoryb, title, content, wdate}) => {
    const [cont, setCont] = useState('');
    const c = content.replaceAll("\u0026nbsp;", " ").substring(0, 80);
    
    useEffect(()=>{
       setCont(c);
    }, []);
    return (
        <Col md={4} className='mb-4'>
            <Card>
                <Card.Img variant='top' src={img} alt={img} />
                <Card.Body>
                    <Card.Title>{title}
                        <small>
                            <span>{categorya}</span>
                            <span>{categoryb}</span>
                        </small>
                        </Card.Title>
                        <Card.Text>                        
                            {content} [{wdate}]
                        </Card.Text>
                        <div className='btnbox'>{writer}
                            <Button variant="dark">바로가기</Button>
                        </div>
                </Card.Body>
            </Card>
        </Col>
    );
};

export default Post;