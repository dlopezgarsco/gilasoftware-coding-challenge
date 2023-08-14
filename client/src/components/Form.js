import React from "react"
import { useState, useEffect} from "react"

export default function Form({ updateLogs }) {
  const [categories, setCategories] = useState([])
  const [categoryId, setCategoryId] = useState(0)
  const [message, setMessage] = useState('')

  useEffect(() => {
    const fetchData = async () => {
      const response = await fetch('http://localhost:8080/api/category')
      const result = await response.json()
      setCategories(result)
      setCategoryId(result[0].categoryId)
    }
    fetchData()
    }, [])

  const handleSubmit = (e) => {
    e.preventDefault()
    const body = {
      categoryId: categoryId,
      message: message
    }
    const insertData = async () => {
      await fetch('http://localhost:8080/api/notification', {
        method: 'POST',
        headers: new Headers({'Accept': 'application/json', 'Content-Type': 'application/json'}),
        body: JSON.stringify(body)
      })
    }
    insertData()
    updateLogs()
  }


  const listCategories = categories.map(c =>
    <option key={c.categoryId} value={c.categoryId}>
      {c.name}
    </option>
  )

  return (
      <form onSubmit={handleSubmit}>
        <label>Category</label>
        <select
          value={categoryId}
          onChange={e => setCategoryId(+e.target.value)}
        >{listCategories}</select>
        <label>Message</label>
        <textarea
          required
          value={message}
          onChange={e => setMessage(e.target.value)}/>
        <button type="submit">Submit</button>
      </form>
  )
}
