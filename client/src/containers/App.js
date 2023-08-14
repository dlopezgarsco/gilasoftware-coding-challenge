import React, { useState, useEffect }from "react"
import Form from '../components/Form'
import NotificationLog from '../components/NotificationLog'

const App = () => {
  const [logs, setLogs] = useState(null)

  const fetchLogs = async () => {
    try {
      const response = await fetch(`http://localhost:8080/api/notification/log`)
      const result = await response.json()
      setLogs(result)
    } catch (e) {
      console.error(e)
    }
  }

  useEffect(() => {
      fetchLogs()
  }, [])

  if (!logs) return (<h2>Please check your API Server</h2>)
  else return (
    <main>
      <h1>Gila Code Challenge</h1>
      <Form updateLogs={fetchLogs}/>
      <NotificationLog logs={logs}/>
    </main>
  )
}

export default App
