package main

/*
	https://www.hackerrank.com/challenges/append-and-delete/problem
*/

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"strconv"
	"strings"
)

// Complete the appendAndDelete function below.
func appendAndDelete(s string, t string, k int32) string {
	var numOperations int = 0
	if len(s) > len(t) {
		numOperations = numOperations + (len(s) - len(t))
		s = s[0:len(t)]
	}
	var index int
	for index = 0; index < len(s); index++ {
		fmt.Println("len(s): ", len(s))
		if s[index] != t[index] {
			break
		}
	}
	if index == len(s) {
		if len(s) < len(t) {
			numOperations += (len(t) - len(s))
		} else {
			numOperations = numOperations + (len(s)-index)*2
		}
	} else {
		if len(s) < len(t) {
			numOperations += ((len(s) - index - 1) * 2) + (len(t) - len(s))
		} else {
			numOperations = numOperations + (len(s)-index)*2
		}
	}
	if int32(numOperations) > k {
		return "No"
	} else {
		extraOperations := k - int32(numOperations)
		if extraOperations%2 == 0 || len(t) == 0 || k > int32(len(t)*2) {
			return "Yes"
		} else {
			return "No"
		}
	}
}

func main() {
	reader := bufio.NewReaderSize(os.Stdin, 1024*1024)

	stdout, err := os.Create(os.Getenv("OUTPUT_PATH"))
	checkError(err)

	defer stdout.Close()

	writer := bufio.NewWriterSize(stdout, 1024*1024)

	s := readLine(reader)

	t := readLine(reader)

	kTemp, err := strconv.ParseInt(readLine(reader), 10, 64)
	checkError(err)
	k := int32(kTemp)

	result := appendAndDelete(s, t, k)

	fmt.Fprintf(writer, "%s\n", result)

	writer.Flush()
}

func readLine(reader *bufio.Reader) string {
	str, _, err := reader.ReadLine()
	if err == io.EOF {
		return ""
	}

	return strings.TrimRight(string(str), "\r\n")
}

func checkError(err error) {
	if err != nil {
		panic(err)
	}
}
