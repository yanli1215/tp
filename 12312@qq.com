{
  "account": "12312@gmail.com",
  "password": "12312",
  "inbox":[
    {"from": "21312@gmail.com",
      "to":  "12312@gmail.com",
      "Subject":  "This is Subject 1",
      "time":  "2020-4-23+01:00",
      "content": "This is content for s1."
    },
    {"from": "21312@gmail.com",
      "to":  "12312@gmail.com",
      "Subject":  "This is Subject 2",
      "time":  "2020-4-23+02:00",
      "content": "This is content for s2."
    }
  ],
  "drafts":[
    {"from": "21312@gmail.com",
      "to":  "12312@gmail.com",
      "Subject":  "This is Subject 3",
      "time":  "2020-4-23+03:00",
      "content": "This is content for s3."
    },
    {"from": "21312@gmail.com",
      "to":  "12312@gmail.com",
      "Subject":  "This is Subject 4",
      "time":  "2020-4-23+04:00",
      "content": "This is content for s4."
    }
  ],
  "archive": [
    {"from": "21312@gmail.com",
      "to":  "12312@gmail.com",
      "Subject":  "This is Subject 5",
      "time":  "2020-4-23+05:00",
      "content": "This is content for s5."
    },
    {"from": "21312@gmail.com",
      "to":  "12312@gmail.com",
      "Subject":  "This is Subject 6",
      "time":  "2020-4-23+06:00",
      "content": "This is content for s6."
    }
  ],
  "sent": [
    {"from": "21312@gmail.com",
      "to":  "12312@gmail.com",
      "Subject":  "This is Subject 7",
      "time":  "2020-4-23+07:00",
      "content": "This is content for s7."
    },
    {"from": "21312@gmail.com",
      "to":  "12312@gmail.com",
      "Subject":  "This is Subject 8",
      "time":  "2020-4-23+08:00",
      "content": "This is content for s8."
    }
  ],
  "deleted": [
    {"from": "21312@gmail.com",
      "to":  "12312@gmail.com",
      "Subject":  "This is Subject 9",
      "time":  "2020-4-23+09:00",
      "content": "This is content for s9."
    },
    {"from": "21312@gmail.com",
      "to":  "12312@gmail.com",
      "Subject":  "This is Subject 10",
      "time":  "2020-4-23+10:00",
      "content": "This is content for s1. "
    }
  ],
  "junk":[
    {"from": "21312@gmail.com",
      "to":  "12312@gmail.com",
      "Subject":  "This is Subject 11",
      "time":  "2020-4-23+11:00",
      "content": "This is content for s1. "
    }
  ]
}


