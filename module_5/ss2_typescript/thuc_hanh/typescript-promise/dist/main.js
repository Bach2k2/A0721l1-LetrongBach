let money = 9000;
const buyACar = (car) => {
    return new Promise(((resolve, reject) => {
        setTimeout(() => {
            if (money >= 10000) {
                resolve("can buy " + car);
            }
            else {
                reject("Do not enough money");
            }
        }, 10000000);
    }));
};
//money = 1000001;
const promise = buyACar("Vinfast").then(value => {
    console.log(value);
}, error => {
    console.log(error);
});
//# sourceMappingURL=main.js.map