import React, {useState} from 'react';
import {Button, Form, Stack} from "react-bootstrap";

function Books() {
    const [search, setSearch] = useState('');

    function handleSearch() {
        console.log(search);
    }

    return (
        <div>
            <Stack direction="horizontal" gap={3}>
                <Form.Control type="text" placeholder="Normal text" value={search}
                              onChange={(e) => setSearch(e.target.value)}/>
                <Button variant="secondary" type="submit"  onClick={handleSearch}/></Stack>
        </div>
    );
}

export default Books;