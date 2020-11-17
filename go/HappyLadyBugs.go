package main

/*
	https://www.hackerrank.com/challenges/happy-ladybugs
*/

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"strconv"
	"strings"
)

// Complete the happyLadybugs function below.
func happyLadybugs(b string) string {
	ladyBugCount := make(map[string]int)
	alreadyHappy := true
	for index, char := range b {
		ladyBugCount[string(char)]++
		if index == 0 {
			if index+1 < len(b) && string(b[index+1]) != string(char) {
				alreadyHappy = false
			}
		} else if index == len(b)-1 {
			if index-1 >= 0 && string(b[index-1]) != string(char) {
				alreadyHappy = false
			}
		} else {
			if (string(b[index-1]) != string(char)) && (string(b[index+1]) != string(char)) {
				alreadyHappy = false
			}
		}
	}
	if alreadyHappy && len(b) {
		return "YES"
	}
	//fmt.Println("ladyBugCount: ", ladyBugCount)
	if _, ok := ladyBugCount["_"]; ok {
		for key, value := range ladyBugCount {
			if key != "_" && value < 2 {
				//fmt.Printf("returning no since %s has only %d in number\n", key, value)
				return "NO"
			}
		}
	} else {
		//fmt.Println("returning no since no empty spaces")
		return "NO"
	}
	return "YES"
}

func main() {
	reader := bufio.NewReaderSize(os.Stdin, 1024*1024)

	// stdout, err := os.Create(os.Getenv("OUTPUT_PATH"))
	stdout, err := os.Create("a.out")
	checkError(err)

	defer stdout.Close()

	writer := bufio.NewWriterSize(stdout, 1024*1024)

	gTemp, err := strconv.ParseInt(readLine(reader), 10, 64)
	checkError(err)
	g := int32(gTemp)

	for gItr := 0; gItr < int(g); gItr++ {
		nTemp, err := strconv.ParseInt(readLine(reader), 10, 64)
		checkError(err)
		n := int32(nTemp)
		fmt.Printf("%d\n", n)

		b := readLine(reader)

		result := happyLadybugs(b)

		fmt.Fprintf(writer, "%s\n", result)
	}

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
