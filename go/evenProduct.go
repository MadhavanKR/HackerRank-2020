package main

import "fmt"

func main() {
	input := []int{1, 3}
	fmt.Println(solve(input))
}

func solve(A []int) int {
	n := len(A)
	result := 0
	for r := 1; r < n+1; r++ {
		result = result + ncr(n, r)
	}
	return result
}

func ncr(n int, r int) int {
	combinations := factorial(n) / (factorial(r) * factorial(n-r))
	return combinations
}

func factorial(n int) int {
	fact := 1
	for i := 0; i < n; i++ {
		fact = fact * (i + 1)
	}
	return fact
}
