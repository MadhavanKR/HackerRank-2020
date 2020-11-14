package main

/*
https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem
*/

import (
	"bufio"
	"fmt"
	"io"
	"math"
	"os"
	"strconv"
	"strings"
)

// Complete the beautifulDays function below.
func beautifulDays(startDate int32, endDate int32, k int32) int32 {
	var numBeautifulDays int32 = 0
	for curDate := startDate; curDate <= endDate; curDate++ {
		if int32(math.Abs(float64(curDate-getReverseOfNumber(curDate))))%k == 0 {
			numBeautifulDays++
		}
	}
	return numBeautifulDays
}

func getReverseOfNumber(number int32) int32 {
	reverse := ""
	for number > 0 {
		remainder := number % 10
		reverse = reverse + strconv.Itoa(int(remainder))
		number = number / 10
	}
	reverseNum, err := strconv.Atoi(reverse)
	//fmt.Println("reverse string is ", reverseNum)
	if err != nil {
		fmt.Println("error occured?")
		return -1
	}
	//fmt.Printf("reverse of %d is %d\n", number, reverseNum)
	return int32(reverseNum)
}

func main() {
	reader := bufio.NewReaderSize(os.Stdin, 1024*1024)

	stdout, err := os.Create(os.Getenv("OUTPUT_PATH"))
	checkError(err)

	defer stdout.Close()

	writer := bufio.NewWriterSize(stdout, 1024*1024)

	ijk := strings.Split(readLine(reader), " ")

	iTemp, err := strconv.ParseInt(ijk[0], 10, 64)
	checkError(err)
	i := int32(iTemp)

	jTemp, err := strconv.ParseInt(ijk[1], 10, 64)
	checkError(err)
	j := int32(jTemp)

	kTemp, err := strconv.ParseInt(ijk[2], 10, 64)
	checkError(err)
	k := int32(kTemp)

	result := beautifulDays(i, j, k)

	fmt.Fprintf(writer, "%d\n", result)

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
