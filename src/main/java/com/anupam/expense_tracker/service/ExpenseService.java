package com.anupam.expense_tracker.service;

import com.anupam.expense_tracker.exception.ResourceNotFoundException;
import com.anupam.expense_tracker.model.Expense;
import com.anupam.expense_tracker.model.User;
import com.anupam.expense_tracker.repository.ExpenseRepository;
import com.anupam.expense_tracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public ExpenseService(ExpenseRepository expenseRepository,
                          UserRepository userRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }

    // Add Expense
    public Expense addExpense(Long userId, Expense expense) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        expense.setUser(user);

        // set today's date automatically
        expense.setDate(LocalDate.now());

        return expenseRepository.save(expense);
    }

    // Get all expenses of user
    public List<Expense> getUserExpenses(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return expenseRepository.findByUser(user);
    }

    public Map<String, Double> getSummary(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        List<Expense> expenses = expenseRepository.findByUser(user);

        Map<String, Double> summary = new HashMap<>();

        double total = 0;

        for (Expense e : expenses) {

            total += e.getAmount();

            String category = e.getCategory();

            summary.put(category,
                    summary.getOrDefault(category, 0.0) + e.getAmount());
        }

        summary.put("total", total);

        return summary;
    }
}