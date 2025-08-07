import React, { useState } from 'react';
import { useEffect } from 'react';
import { Button, Container, Form, Stack, Table } from "react-bootstrap";
import { ApiService } from '../../services/api-service';

function Books() {
    const [search, setSearch] = useState('');
    const [books, setBooks] = useState([]);
    const [isError, setIsError] = useState(false);
    const [errorMsg, setErrorMsg] = useState('');

    function handleSearch() {
        console.log(search);
    }
    const getAllBooks = async () => {
        const response = await ApiService.getBooks().then(resp => {
            if (resp.data?.status === 'Success') {
                setIsError(false);
                setBooks(resp.data?.data);
            } else {
                setIsError(true);
                setErrorMsg(resp.data?.error_message);
            }
        }).catch(err => {
            setIsError(true);
            setErrorMsg(err);
        });
    }
    useEffect(() => {
        getAllBooks();
    }, [])

    return (
        <div>
            <Container>
                <Stack direction="vertical" gap={3} className="flex right">
                    <Stack direction="horizontal" gap={3}>
                        <Form.Control type="text" placeholder="Book title" value={search}
                            onChange={(e) => setSearch(e.target.value)} />
                        <Button variant="secondary" onClick={handleSearch}>Search</Button></Stack>
                    <Stack direction="horizontal" gap={3}>
                        <div className="me-auto"></div>
                        <Button variant="secondary" onClick={handleSearch}>Request Books</Button></Stack>
                    <Table striped bordered hover>
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Book Title</th>
                                <th>Author</th>
                                <th>Total Qty</th>
                                <th>Available Qty</th>
                            </tr>
                        </thead>
                        <tbody>
                            {isError ? (
                                <tr>
                                    <td colSpan={5} className="text-danger text-center">{errorMsg.toString()}</td>
                                </tr>
                            ) : books.length === 0 ? (
                                <tr>
                                    <td colSpan={5} className="text-center">No books found.</td>
                                </tr>
                            ) : (
                                books.map((book, index) => (
                                    <tr key={index}>
                                        <td><Form.Check value={book.id}
                                        /></td>
                                        <td>{book.title}</td>
                                        <td>{book.author}</td>
                                        <td>0</td>
                                        <td>0</td>
                                    </tr>
                                ))
                            )}
                        </tbody>
                    </Table>
                </Stack>
            </Container>
        </div>
    );
}

export default Books;