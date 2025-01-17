function solution(my_str, n) {
    var answer = [];
    let jo = Math.ceil(my_str.length / n)
    for(let i = 0; i < jo; i++){
        j = i * n;
        answer[i] = my_str.slice(j, j+n)
    }
    return answer;
}
