import React from "react"
import { useState, useEffect } from "react"

export default function NotificationLog({logs}) {

  const tableBody = logs.map(row =>
    <tr key={row.notificationLogId}>
      <td>{row.notificationLogId}</td>
      <td>{row.notificationId}</td>
      <td>{row.userId}</td>
      <td>{row.channelId}</td>
      <td>{new Date(...row.timestamp).toString()}</td>
      <td>{row.success.toString()}</td>
    </tr>
  )

  const tableHead = ['Log ID', 'Notification ID', 'User ID', 'Channel ID', 'Timestamp', 'Success']
        .map(th =>
          <th key={th}>{th}</th>
        )
  if (!logs)
    return null
  else
    return (
      <table>
        <thead>
          <tr>{tableHead}</tr>
        </thead>
        <tbody>{tableBody}</tbody>
      </table>
    )
}
