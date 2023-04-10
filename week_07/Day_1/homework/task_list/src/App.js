import './App.css';
import React, { useState } from 'react';

const App = () => {
  const [tasks, setTask] = useState([
    { name: 'Go for Run', priority: 'medium', isDone: false },
    { name: 'Buy Shopping', priority: 'medium', isDone: true },
    { name: 'Pay Bills', priority: 'high', isDone: true },
    { name: 'Visit Family', priority: 'high', isDone: false },
  ]);

  const [priority, setPriority] = useState('');
  const priorities = [{ name: 'low' }, { name: 'medium' }, { name: 'high' }];

  const [newTask, setNewTask] = useState('');

  const taskItems = tasks.map((task, index) => {
    return (
      <li key={index} className={task.isDone ? 'done' : 'not-done'}>
        {task.isDone ? <s>{task.name}</s> : task.name}
        <span className={!task.isDone ? 'priority' : 'no-priority'}>
          {task.isDone ? <s>{task.priority}</s> : task.priority}
        </span>
        {task.isDone ? (
          <span className='done'>Done!</span>
        ) : (
          <button onClick={() => doneItem(index)}>Done</button>
        )}
      </li>
    );
  });

  const handleItemInput = event => {
    setNewTask(event.target.value);
  };

  const saveNewTask = event => {
    event.preventDefault();
    const copyTasks = [...tasks];
    console.log(copyTasks);
    copyTasks.push({ name: newTask, priority, isDone: false });
    setTask(copyTasks);
    setNewTask('');
  };

  const doneItem = index => {
    const copyTasks = [...tasks];
    const updatedTask = { ...copyTasks[index] };
    updatedTask.isDone = true;
    copyTasks[index] = updatedTask;
    setTask(copyTasks);
  };

  return (
    <div className='App'>
      <h1>Task List</h1>
      <hr></hr>

      <ul>{taskItems}</ul>

      <form onSubmit={saveNewTask}>
        <label htmlFor='new-item'>Add a new task:</label>
        <input id='new-item' type='text' onChange={handleItemInput} />

        <select value={priority} onChange={e => setPriority(e.target.value)}>
          <option value='Choose priority'>Choose priority:</option>

          {priorities.map(cat => (
            <option key={cat.name} value={cat.name}>
              {cat.name.toUpperCase()}{' '}
            </option>
          ))}
        </select>

        <input type='submit' value='Save New Item' />
      </form>
    </div>
  );
};

export default App;
