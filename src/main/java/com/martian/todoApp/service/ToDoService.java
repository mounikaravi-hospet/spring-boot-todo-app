package com.martian.todoApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martian.todoApp.model.ToDo;
import com.martian.todoApp.repository.ToDoRepository;

@Service
public class ToDoService {
	@Autowired
	ToDoRepository todoRepo;
	
	public List<ToDo> getAllToDoItems(){
		List<ToDo> todoList = new ArrayList<>();
		todoRepo.findAll().forEach(todo -> todoList.add(todo));
		
		return todoList;
	}
	
	public ToDo getToDoItemById(Integer id){
		return todoRepo.findById(id).get();
	}
	
	public boolean updateStatus(Integer id){
		ToDo todo = getToDoItemById(id);
		todo.setStatus("Completed");
		
		return saveOrUpdateToDoItem(todo);
	}

	public boolean saveOrUpdateToDoItem(ToDo todo){
		ToDo updatedObj = todoRepo.save(todo);
		if(getToDoItemById(updatedObj.getId()) != null) {
			return true;
		}
		return false;
	}
	
	public boolean deleteToDoItem(Integer id){
		todoRepo.deleteById(id);
		if(todoRepo.findById(id).isEmpty()) { //checking if we successfully deleted the item. It id doesn't exist, it means it has been deleted
			return true;
		}
		return false;
		}
}
