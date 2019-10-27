var args = process.argv.splice(2);
var http = require('http');

function trial_division3(N){
    F=[];

    while(N%2n==0n){
        N = N/2n;
        F.push (2n);
    }
    d = 3n;
    while(d*d <= N){
        while(N%d == 0n){
            N = N/d;
            F.push (d);
        }
        d = d+2n;
    }
    if (N != 1n){
        F.push (N);
    }
    return F;
}

http.createServer(function (req, res) {
    console.log("Server started at localhost:8000" );
    res.writeHead(200, {'Content-Type': 'text/plain' });
    console.log("Request Started: " + (new Date().toLocaleTimeString()));
    res.end('array with primes : ' + trial_division3(1092343544502342n));
    console.log("Request End: " + (new Date().toLocaleTimeString()));
}).listen(args[0]||8000);
console.log("Server started at localhost:8000" );
